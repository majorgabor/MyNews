
package hu.elte.mynews.service;

import hu.elte.mynews.entity.Report;
import hu.elte.mynews.exception.ReportException;
import hu.elte.mynews.repository.ReportRepository;
import java.util.Date;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.context.annotation.SessionScope;

@Service
@SessionScope
@Data
public class ReportService {
    @Autowired
    private ReportRepository reportRespository;
    @Autowired
    private UserService userService;
    
    public Report newReport(Report report) throws ReportException{
        if(report.getText().length() > 0){
            report.setDate(new Date());
            report.setUser(userService.getCurrentUser());
            reportRespository.save(report);
            return report;
        } else {
            throw new ReportException();
        }
    }
    
    public Iterable<Report> listReports(){
        return reportRespository.findAll();
    }
}
