/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hu.elte.mynews.controller;

import hu.elte.mynews.annotation.Role;
import hu.elte.mynews.entity.Report;
import static hu.elte.mynews.entity.User.Role.ADMIN;
import static hu.elte.mynews.entity.User.Role.USER;
import hu.elte.mynews.exception.ReportException;
import hu.elte.mynews.service.ReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/news/report")
public class ReportController {
    @Autowired
    private ReportService reportService;
    
    @Role({USER, ADMIN})
    @PostMapping("")
    private ResponseEntity<Report> newReport(@RequestBody Report report){
        try{
            return ResponseEntity.ok(reportService.newReport(report));
        } catch (ReportException ex) {
            return ResponseEntity.badRequest().build();
        }
    }
}
