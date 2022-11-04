package com.example.bonus;



import com.example.bonus.dataAccess.RequestRepository;
import com.example.bonus.models.Author;
import com.example.bonus.models.Request;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.groupingBy;

@Component
@Log
public class PaymentService implements IPaymentService {
    @Autowired
    RequestRepository repository;

    @Autowired
    AuthorController authorController;

    public void payAuthors(){
        log.info("start payment");
        //get first day of last month
        LocalDateTime since = LocalDateTime.now().minusMonths(1).withDayOfMonth(1).minusDays(1);

        //find all timestamps grouped by authorid
        var timestamps = repository.findAllByTimestampAfter(since).stream().collect(groupingBy(Request::getFk_author));


        //get the corresponding authors
        var authorMap = authorController.getAuthors()
                .stream()
                .collect(Collectors.toMap(Author::getId,author -> author));


        //calculate the value
        Map<Author,Double> listOfPayments = new HashMap<>();
        for(var key : timestamps.keySet()){
            listOfPayments.put(authorMap.get(key),((double) timestamps.get(key).size())/100);
        }

        //pay customers
        //TODO proper payment service
        for(var author : listOfPayments.keySet()){
            log.info("Payment to: "+ author.getFirstName()+" "+author.getLastName()+", amount: "+listOfPayments.get(author)+"€");
        }

    }
}
