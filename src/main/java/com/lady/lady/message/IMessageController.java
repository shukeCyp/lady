package com.lady.lady.message;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


public interface IMessageController {


    @RequestMapping(value = "/message/message_list",
            produces = {"application/json"},
            method = RequestMethod.GET)
    @CrossOrigin
    public String getMessageList();

    @RequestMapping(value = "/message/versionCode",
            produces = {"application/json"},
            method = RequestMethod.GET)
    @CrossOrigin
    public String getVersionCode();


    @RequestMapping(value = "/message/downloadLink",
            produces = {"application/json"},
            method = RequestMethod.GET)
    @CrossOrigin
    public String getDownloadLink();

    @RequestMapping(value = "/message/groupKey",
            produces = {"application/json"},
            method = RequestMethod.GET)
    @CrossOrigin
    public String getGroupKey();
}
