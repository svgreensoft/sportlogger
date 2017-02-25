package org.sversh.sportlogger.web.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.bind.JAXBException;
import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.parsers.ParserConfigurationException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.sversh.sportlogger.service.api.PressureService;
import org.xml.sax.SAXException;

import javassist.NotFoundException;

/**
 * 
 * 
 * @author Sergey Vershinin
 *
 */
@Controller
public class SLController {
    
    @Autowired
    private PressureService pressureService;

    @RequestMapping(method = RequestMethod.POST, value = "/pressure/sys/{sys}/dias/{dias}", produces = {
            "application/xml" })
    public void addPresure(HttpServletResponse resp, @PathVariable String sys, @PathVariable String dias)
            throws SAXException, IOException, JAXBException, NotFoundException, DatatypeConfigurationException {
        pressureService.addPressure(Short.valueOf(sys), Short.valueOf(dias));
    }
    
    @RequestMapping(method = RequestMethod.GET, value = "/echo")
    public void echo(HttpServletRequest req, HttpServletResponse resp) 
            throws IOException, JAXBException, 
                ParserConfigurationException, SAXException {
            resp.setStatus(org.springframework.http.HttpStatus.OK.value());
            resp.getOutputStream().print("Order service is running");
    }


}
