package id.ac.ui.cs.advprog.tutorial1.newsletter.controller;

import id.ac.ui.cs.advprog.tutorial1.newsletter.service.NewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Map;


@Controller
@RequestMapping(path = "/newsletter")
public class NewsletterController {

    @Autowired
    private NewsService newsService;

    @RequestMapping(path = "", method = RequestMethod.GET)
    public String home(Model model) {
        Map<String, List<String>> newsByUsersName = newsService.getNewsFromAllUsers();
        List<String> newslettersName = newsService.getAllNewslettersName();

        model.addAttribute("map", newsByUsersName);
        model.addAttribute("newsletters", newslettersName);

        return "newsletter/home";
    }

    @RequestMapping(path = "", method = RequestMethod.POST)
    public String handleNewBroadcast(Model model, @RequestParam(value = "newsletterName") String newsletterName) {
        // TODO: Lengkapi method ini

        return "redirect:/newsletter";
    }

    @RequestMapping(path = "/subscribe", method = RequestMethod.GET)
    public String subscribe(Model model) {
        List<String> usersName = newsService.getAllUsersName();
        List<String> newslettersName = newsService.getAllNewslettersName();
        Map<String, List<String>> subscribersNameByNewsletterName = newsService.getSubscribersFromAllNewsletter();

        model.addAttribute("users", usersName);
        model.addAttribute("newsletters", newslettersName);
        model.addAttribute("map", subscribersNameByNewsletterName);

        return "newsletter/subscribe";
    }

    @RequestMapping(params="subscribe", path = "/subscribe", method = RequestMethod.POST)
    public String handleSubscribe(Model model,
                                  @RequestParam(value = "userName") String userName,
                                  @RequestParam(value = "newsletterName") String newsletterName) {
        // TODO: Lengkapi method ini

        return "redirect:/newsletter/subscribe";
    }

    @RequestMapping(params="unsubscribe", path = "/subscribe", method = RequestMethod.POST)
    public String handleUnsubscribe(Model model,
                                  @RequestParam(value = "userName") String userName,
                                  @RequestParam(value = "newsletterName") String newsletterName) {
        // TODO: Lengkapi method ini

        return "redirect:/newsletter/subscribe";
    }
}
