/**
 * 
 */
package org.sversh.sportlogger.web.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.bind.JAXBException;
import javax.xml.parsers.ParserConfigurationException;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.xml.sax.SAXException;

/**
 * @author sergey
 *
 */
@Controller
@RequestMapping("/jsp")
public class JspController {

    @RequestMapping(method = RequestMethod.GET, value = "/adddistance")
    public String addDistance(HttpServletRequest req, HttpServletResponse resp) 
            throws IOException, JAXBException, 
                ParserConfigurationException, SAXException {
            //resp.setStatus(org.springframework.http.HttpStatus.OK.value());
            //resp.getOutputStream().print("Order service is running");
			return "adddistance";
    }

}
