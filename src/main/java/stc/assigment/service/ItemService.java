package stc.assigment.service;

import java.io.IOException;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import stc.assigment.model.Item;
import stc.assigment.model.PermissionGroup;
import stc.assigment.model.TreeNode;
import stc.assigment.model.Type;
import stc.assigment.model.request.ItemRequest;
import stc.assigment.model.request.SpaceRequest;
import stc.assigment.repo.*;
import stc.assigment.ex.DirectoryExceptionHandler;
import stc.assigment.ex.UserNotAuthorizedException;
import stc.assigment.model.*;

@Service
public class ItemService {

	private TreeNode root;
	@Autowired
	private ItemRepository itemRepository;
	@Autowired
	private FileRepository fileRepository;
	@Autowired
	private PermissionGroupRepository groupRepository;
	@Autowired
	private PermissionRepository permissionRepository;
	
	public void createSpace(SpaceRequest space) {
		Optional<PermissionGroup> group =  Optional.ofNullable(groupRepository.findByGroupName(space.getPermissionGroupName()));
		if(group.isPresent()) {
			Item item = new Item();
			item.setName(space.getSpaceName());
			item.setPermissionGroup(group.get());
			item.setType(Type.SPACE);
			root = new TreeNode(item);
			itemRepository.save(item);
		}
	}
	
	public void createFolder(ItemRequest itemRequest) {
		Optional<Permission> permission = Optional.ofNullable(permissionRepository.findByUserEmail(itemRequest.getUserEmail()));
		if(permission.isPresent() && permission.get().getLevel().equals(PermissionLevel.EDIT)) {
			Optional<Item> parentItem = Optional.ofNullable(itemRepository.findByName(itemRequest.getParent()));
			if(parentItem.isPresent()) {
				Item newItem = new Item();
				newItem.setName(itemRequest.getFolderName());
				newItem.setPermissionGroup(parentItem.get().getPermissionGroup());;
				newItem.setType(Type.FOLDER);
				newItem.setParentItem(parentItem.get());
				itemRepository.save(newItem);
				root.addChild(newItem);
				
			}else {
				new DirectoryExceptionHandler("this Directory not found to put this folder");
			}
		}else {
			new UserNotAuthorizedException("this User No Have Permission to Edit");
		}
		
	}
	
	public void createFile(ItemRequest itemRequest , MultipartFile file) throws IOException {
		Optional<Permission> permission = Optional.ofNullable(permissionRepository.findByUserEmail(itemRequest.getUserEmail()));
		if(permission.isPresent() && permission.get().getLevel().equals(PermissionLevel.EDIT)) {
			Optional<Item> parentItem = Optional.ofNullable(itemRepository.findByName(itemRequest.getParent()));
			if(parentItem.isPresent()) {
				Item newItem = new Item();
				File newFile = new File();
				newItem.setName(itemRequest.getFolderName());
				newItem.setPermissionGroup(parentItem.get().getPermissionGroup());
				newItem.setType(Type.FILE);
				newItem.setParentItem(parentItem.get());
				newFile.setContent(file.getBytes());
				newItem.setFile(newFile);
				itemRepository.save(newItem);
				TreeNode childNode = root.getChildren().stream().filter(child -> child.getData().getName().equals(parentItem.get().getName()))
				.findAny().orElse(root);
				childNode.addChild(newItem);
			}
		}
	}
	
}
