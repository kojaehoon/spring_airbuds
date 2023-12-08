package com.kdt.controllers;


import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;


import com.kdt.dto.TrackDTO;
import com.kdt.services.TrackService;

@RestController
@RequestMapping("/api/track")
public class TrackController {
	
	
	@Autowired
	TrackService tService;
	
	@PostMapping
    public ResponseEntity<Void> uploadMusic(@RequestParam("file") MultipartFile[] files, 
    										@RequestParam("duration") String[] durations,
    										@RequestParam("image_path") String[] image_path,
    										@RequestParam(value = "imagefile", required = false) MultipartFile[] imagefile,
    										@RequestParam("writer") String[] writer,
    										@RequestParam("tag") String[] tag) throws Exception {
		

//		System.out.println("image_path : "+image_path[0]+" writer : "+writer[0]+" tag : "+tag[0]);
//		System.out.println("imagefile: "+ imagefile[0]);
//		

		tService.insert(files,durations,image_path,imagefile,writer,tag);
        return ResponseEntity.ok().build();
    }
	
	@GetMapping
	public ResponseEntity<List<TrackDTO>> selectAll(){
		List<TrackDTO> dtos=tService.selectAll();
		return ResponseEntity.ok(dtos);
	}
	

	@GetMapping("/bywriter/{writer}")
	public ResponseEntity<List<TrackDTO>> selectByWriter(@PathVariable String writer){
		List<TrackDTO> dtos=tService.selectByWriter(writer);
		return ResponseEntity.ok(dtos);
	}

	@GetMapping("/recent")
	public ResponseEntity<List<TrackDTO>> recentAll() {
		List<TrackDTO> dtos=tService.recentAll();

		return ResponseEntity.ok(dtos);
	}
	
	@DeleteMapping("/{track_id}")
	public ResponseEntity<Void> deleteByIdTrack(@PathVariable String track_id){
		
		tService.deleteByIdTrack(track_id);
		return ResponseEntity.ok().build();
	}
	
	

}
