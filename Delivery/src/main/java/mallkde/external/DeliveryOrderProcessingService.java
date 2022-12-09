package mallkde.external;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Date;

@FeignClient(name = "Delivery", url = "${api.url.Delivery}")
public interface DeliveryOrderProcessingService {
    @RequestMapping(method= RequestMethod.GET, path="/deliveryOrderProcessings/{id}")
    public DeliveryOrderProcessing getDeliveryOrderProcessing(@PathVariable("id") Long id);
}

