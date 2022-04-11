package hello.springmvc.basic.requestmapping;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

@RestController
public class MappingController {

    private Logger log = LoggerFactory.getLogger((getClass()));

    @RequestMapping(value = "/hello-basic")
    public String helloBasic() {
        log.info("helloBasic");
        return "ok";
    }

    @RequestMapping(value = "/mapping-get-v1", method = RequestMethod.GET)
    public String MappingGetV1() {
        log.info("MappingGetV1");
        return "ok";
    }

    @GetMapping(value = "/mapping-get-v2")
    public String MappingGetV2() {
        log.info("MappingGetV2");
        return "ok";
    }

    //pathVariable 스타일
    @GetMapping("/mapping/{userId}")
    public String mappingPath(@PathVariable("userId") String data) {
        log.info("mappingPath userId={}", data);
        return "ok";
    }

    //pathVariable 다중매핑
    @GetMapping("/mapping/users/{userId}/orders/{orderId}")
    public String mappingPath(@PathVariable String userId, @PathVariable Long orderId) {
        log.info("mappingPath userId={}, orderId={}", userId, orderId);
        return "ok";
    }

    //params의 값이 있어야 호출 - 거의안씀
    @GetMapping(value = "/mapping-param", params = "mode=debug")
    public String mappingPath() {
        log.info("mappingParam");
        return "ok";
    }

    //header에 따른 요청
    @GetMapping(value = "/mapping-header", headers = "mode=debug")
    public String mappingHeader() {
        log.info("mappingHeader");
        return "ok";
    }

    //consume - 미디어타입에 따른 매핑
    @PostMapping(value = "/mapping-consume", consumes = "application/json")
    public String mappingConsume() {
        log.info("mappingConsume");
        return "ok";
    }

    //http 요청 accept, produce
    @PostMapping(value = "mapping-produce", produces = "text/html")
    public String mappingProduce() {
        log.info("mappingProduce");
        return "ok";
    }

}
