package springcloud.service;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@Slf4j
public class SentinelService {
    @SentinelResource(value="getOrder",blockHandler = "handleException")
    public String getOrder(){
        log.info("======order====");
        return UUID.randomUUID().toString();
    }

    public String handleException(BlockException ex) {
        System.out.println("县六中............");
        return  ex.getClass().getCanonicalName() + "\t服务不可用";
    }
}
