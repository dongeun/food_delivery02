package mallkde.external;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Date;

@FeignClient(name = "Adress Check", url = "${api.url.Adress Check}")
public interface CheckOederAdressService {
    @RequestMapping(method= RequestMethod.GET, path="/checkOederAdresses/{Order_id}")
    public CheckOederAdress getCheckOederAdress(@PathVariable("Order_id") Long Order_id);
}

