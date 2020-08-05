package PEJ;

import PEJ.config.kafka.KafkaProcessor;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PolicyHandler{

    @Autowired
    PayRepository payRepository;

    @StreamListener(KafkaProcessor.INPUT)
    public void onStringEventListener(@Payload String eventString){

    }

    @StreamListener(KafkaProcessor.INPUT)
    public void wheneverTbcancelled_Cancelpay(@Payload Tbcancelled tbcancelled){

        if(tbcancelled.isMe()){
            System.out.println("##### listener Cancelpay : " + tbcancelled.toJson());
        }
        if(tbcancelled.isMe()){
            System.out.println("##### listener wheneverTbcancelled_Cancelpay : " + tbcancelled.toJson());
            Pay pay = payRepository.findByTbId(tbcancelled.getTbId());
            pay.setPayStatus(tbcancelled.getTbStatus());
            System.out.println("7777777777777 pay.getTbId()=" + pay.getTbId()
                    + " / pay.getPayStatus()=" + pay.getPayStatus());
            payRepository.save(pay);
        }
    }

}
