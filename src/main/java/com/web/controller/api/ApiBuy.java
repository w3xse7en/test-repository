package com.web.controller.api;

import com.web.service.ContentService;
import com.web.service.TransactionService;
import com.web.service.impl.ContentImpl;
import com.web.service.impl.TransactionImpl;
import com.web.entity.ApiBuyInfo;
import com.web.entity.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * Created by Mew on 2017/7/9.
 */
@Controller
public class ApiBuy {
    private ContentService contentService;
    private TransactionService transactionService;

    @Autowired
    public void setProductService(ContentService contentService, TransactionService transactionService) {
        this.transactionService = transactionService;
        this.contentService = contentService;
    }

    @RequestMapping(value = "/api/buy")
    @ResponseBody
    public ModelMap Buy(@RequestBody List<ApiBuyInfo> buyList, ModelMap map, HttpServletRequest request, HttpServletResponse response) {
//        TransactionImpl transactionImpl = new TransactionImpl();
//        ContentImpl contentImpl = new ContentImpl();
        Transaction transaction;
        for (ApiBuyInfo apiBuyInfo : buyList
                ) {
            double price = contentService.getContent(apiBuyInfo.getId()).getPrice();
            if ((transaction = transactionService.getTransaction(apiBuyInfo.getId())) != null) {
                int numb = transaction.getNum() + apiBuyInfo.getNumber();
                transaction.setNum(numb);
                transaction.setPrice(price * numb);
                transaction.setTime(System.currentTimeMillis());
                transactionService.updateTransaction(transaction);
            } else {
                transaction = new Transaction();
                transaction.setContentId(apiBuyInfo.getId());
                transaction.setNum(apiBuyInfo.getNumber());
                transaction.setPrice(price * apiBuyInfo.getNumber());
                transaction.setPersonId(0);
                transaction.setTime(System.currentTimeMillis());
                transactionService.InsertTransaction(transaction);
            }
        }
        map.addAttribute("code", 200);
        map.addAttribute("message", "success");
        map.addAttribute("result", true);
        return map;
    }
}
