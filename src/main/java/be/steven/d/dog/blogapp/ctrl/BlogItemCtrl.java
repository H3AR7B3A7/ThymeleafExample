package be.steven.d.dog.blogapp.ctrl;

import be.steven.d.dog.blogapp.model.BlogItem;
import be.steven.d.dog.blogapp.repo.BlogItemRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;
import java.util.Optional;

@Controller
public class BlogItemCtrl {

    @Autowired
    BlogItemRepo repo;

    @ModelAttribute(value = "blogitems")
    public Iterable<BlogItem> findAllBlogItems() {
        return repo.findAll();
    }

    @ModelAttribute(value = "nBlogItem")
    public BlogItem BlogItemToSave() {
        return new BlogItem();
    }

    @GetMapping(value = "/blogitems")
    public String showBlogItems(ModelMap map) {
        return "blogitems";
    }

    @GetMapping(value = "/blogitems/{id}")
    public Optional<BlogItem> searchById(@PathVariable(value = "id") int id) {
        return repo.findById(id);
    }

    @PostMapping(value = "/blogitems")
    public String saveBlogItem(@ModelAttribute("nBlogItem") @Valid BlogItem nBlogItem, BindingResult bindingResult) {
        if (bindingResult.hasErrors())
            return "blogitems";
        repo.save(nBlogItem);
        return "redirect:/blogitems";
    }

    @GetMapping(value = "/blogitems/delete/{id}")
    public String deleteBlogItem(@PathVariable(value = "id") int id) {
        Optional<BlogItem> optional = repo.findById(id);
        if (optional.isPresent()) {
            repo.deleteById(id);
            return "redirect:/blogitems";
        } return "redirect:/404";
    }
}
