package fooddelivertest.external;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Date;

@FeignClient(name = "payment", url = "${api.url.payment}")
public interface PayHistoryService {
    @RequestMapping(method= RequestMethod.POST, path="/payHistories")
    public void pay(@RequestBody PayHistory payHistory);
}

