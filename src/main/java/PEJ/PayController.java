package PEJ;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.Optional;

@RestController
 public class PayController {

    @Autowired
    PayRepository payRepository;

    @RequestMapping(method=RequestMethod.POST, path="/pays")
    public void pay(@RequestBody Pay pay){
        try {
            Thread.currentThread().sleep((long) (400 + Math.random() * 220));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
//         Pay payed = payRepository.findByTbId(pay.getTbId());
         pay.setPayStatus("PAYED");
         payRepository.save(pay);
    }
 }
