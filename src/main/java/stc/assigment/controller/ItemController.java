package stc.assigment.controller;

import org.apache.catalina.connector.Response;
import org.aspectj.weaver.Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.Base64Utils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import jakarta.websocket.server.PathParam;
import stc.assigment.ex.UserNotAuthorizedException;
import stc.assigment.model.Item;
import stc.assigment.model.request.ItemRequest;
import stc.assigment.model.request.SpaceRequest;
import stc.assigment.service.ItemService;

@RestController
@RequestMapping("/")
public class ItemController {

	@Autowired
	private ItemService itemService;

	@RequestMapping(method = RequestMethod.POST, path = "space")
	public ResponseEntity createSpace(@RequestBody SpaceRequest spaceRequest) {
		if (itemService != null) {
			itemService.createSpace(spaceRequest);
		} else {
			new UserNotAuthorizedException("User Not Authorized");
		}

		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	
	@RequestMapping(method = RequestMethod.POST, path = "folder")
	public ResponseEntity createFolder(@RequestBody ItemRequest itemRequest) {
		if (itemRequest != null) {
			itemService.createFolder(itemRequest);
		} else {
			new UserNotAuthorizedException("User Not Authorized");
		}

		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	
	@RequestMapping(method = RequestMethod.POST, path = "file",consumes = { MediaType.MULTIPART_FORM_DATA_VALUE })
	public ResponseEntity createFile(@RequestPart("itemRequest") ItemRequest itemRequest,@RequestPart("file") MultipartFile file) {
		if (itemRequest != null) {
			try {
				itemService.createFile(itemRequest, file);	
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else {
			new  ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}

		return new ResponseEntity<>(HttpStatus.OK);
	}

}
