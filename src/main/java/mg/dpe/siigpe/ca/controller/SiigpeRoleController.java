package mg.dpe.siigpe.ca.controller;

import java.util.List;
import mg.dpe.siigpe.ca.model.SiigpeRole;
import mg.dpe.siigpe.ca.repository.SiigpeRoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "http://localhost:8080")
@RestController
@RequestMapping("/api")
public class SiigpeRoleController {
     @Autowired
	SiigpeRoleRepository siigpeRoleRepository;

	@GetMapping("/SiigpeRoles")
	public ResponseEntity<List<SiigpeRole>> getAllTutorials(@RequestParam(required = false) String title) {
		
	return null;
		
	}

	@GetMapping("/SiigpeRoles/{id}")
	public ResponseEntity<SiigpeRole> getTutorialById(@PathVariable("id") long id) {
		
	return null;
		
	}

	@PostMapping("/SiigpeRoles")
	public ResponseEntity<SiigpeRole> createTutorial(@RequestBody SiigpeRole sigpeRole) {
		return null;
	}

	@PutMapping("/SiigpeRoles/{id}")
	public ResponseEntity<SiigpeRole> updateTutorial(@PathVariable("id") long id, @RequestBody  SiigpeRole sigpeRole) {
	
	return null;
	
	}

	@DeleteMapping("/SiigpeRoles/{id}")
	public ResponseEntity<HttpStatus> deleteTutorial(@PathVariable("id") long id) {
		
     return null;
	}

	@DeleteMapping("/SiigpeRoles")
	public ResponseEntity<HttpStatus> deleteAllTutorials() {
	
	return null;
	
	}

	@GetMapping("/SiigpeRoles/published")
	public ResponseEntity<List<SiigpeRole>> findByPublished() {
		
	return null;
		
	}
    
}