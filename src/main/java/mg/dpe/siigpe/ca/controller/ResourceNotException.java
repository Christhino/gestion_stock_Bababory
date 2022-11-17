/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mg.dpe.siigpe.ca.controller;

import mg.dpe.siigpe.ca.model.SiigpeUser;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 *
 * @author BasilisseN
 */
@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class ResourceNotException extends RuntimeException {
    
    private static final long serialVersionID = 1L;
    public ResourceNotException(String message) {
        super(message); 
    }

    
}
