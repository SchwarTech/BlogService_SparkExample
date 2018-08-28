package me.tomassetti.handlers;

import me.tomassetti.AbstractRequestHandler;
import me.tomassetti.Answer;
import me.tomassetti.model.Model;
import me.tomassetti.model.Post;

import java.util.*;
import java.util.stream.Collectors;

import static j2html.TagCreator.*;

public class JeffIndexHandler extends AbstractRequestHandler<EmptyPayload> {

    public JeffIndexHandler(Model model) {
        super(EmptyPayload.class, model);
    }

    @Override
    protected Answer processImpl(EmptyPayload value, Map<String,String> urlParams, boolean shouldReturnHtml) {
        List<String> categories = new ArrayList<>();
        categories.add("Category-11");
        categories.add("Category 22");

        List<Post> allPosts = new ArrayList<>();
        Post p2 = new Post();
        p2.setContent("bar");
        p2.setTitle("Foo");
        p2.setPost_uuid(UUID.randomUUID());
        p2.setPublishing_date(new Date());
        p2.setCategories(categories);
        allPosts.add(p2);

        if (shouldReturnHtml) {
            String html = body().with(
                    h1("My wonderful blog"),
                div().with(allPosts.stream().map((p) ->
                    div().with(
                        h2(p.getTitle()),
                        p(p.getContent()),
                        ul().with(p.getCategories().stream().map((cat) ->
                            li(cat))
                            .collect(Collectors.toList()))))
                    .collect(Collectors.toList()))
            ).render();
            return Answer.ok(html);
        } else {

//            String json = dataToJson(model.getAllPosts());
            String json = dataToJson(allPosts);
            return Answer.ok(json);
        }
    }

}