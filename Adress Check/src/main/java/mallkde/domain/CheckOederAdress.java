package mallkde.domain;

import mallkde.domain.OrderableArea;
import mallkde.domain.UnavailableArea;
import mallkde.AdressCheckApplication;
import javax.persistence.*;
import java.util.List;
import lombok.Data;
import java.util.Date;


@Entity
@Table(name="CheckOederAdress_table")
@Data

public class CheckOederAdress  {


    
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    
    
    
    
    
    private Long id;

    @PostPersist
    public void onPostPersist(){


        OrderableArea orderableArea = new OrderableArea(this);
        orderableArea.publishAfterCommit();



        UnavailableArea unavailableArea = new UnavailableArea(this);
        unavailableArea.publishAfterCommit();

    }

    public static CheckOederAdressRepository repository(){
        CheckOederAdressRepository checkOederAdressRepository = AdressCheckApplication.applicationContext.getBean(CheckOederAdressRepository.class);
        return checkOederAdressRepository;
    }




    public static void inputAdress(OrderPleaced orderPleaced){

        /** Example 1:  new item 
        CheckOederAdress checkOederAdress = new CheckOederAdress();
        repository().save(checkOederAdress);

        */

        /** Example 2:  finding and process
        
        repository().findById(orderPleaced.get???()).ifPresent(checkOederAdress->{
            
            checkOederAdress // do something
            repository().save(checkOederAdress);


         });
        */

        
    }


}
