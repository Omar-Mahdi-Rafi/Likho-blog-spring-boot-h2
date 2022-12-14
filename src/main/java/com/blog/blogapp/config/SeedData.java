package com.blog.blogapp.config;

import com.blog.blogapp.models.Account;
import com.blog.blogapp.models.Post;
import com.blog.blogapp.services.AccountService;
import com.blog.blogapp.services.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class SeedData implements CommandLineRunner {
  @Autowired
  private PostService postService;

  @Autowired
  private AccountService accountService;

  @Override
    public void run(String... args) throws Exception{
      List<Post> posts = postService.getAll();

      if(posts.size() == 0){
          Account account1 = new Account();
          Account account2 = new Account();

          account1.setFirstName("user");
          account1.setLastName("user");
          account1.setEmail("user.user@domain.com");
          account1.setPassword("password");

          account2.setFirstName("admin");
          account2.setLastName("admin");
          account2.setEmail("admin.admin@domain.com");
          account2.setPassword("password");

          accountService.save(account1);
          accountService.save(account2);

          Post post1 = new Post();
          post1.setTitle("Title of post 1");
          post1.setBody("This is the body of post 1");
          post1.setAccount(account1);

          Post post2 = new Post();
          post2.setTitle("Title of post 2");
          post2.setBody("This is the body of post 2");
          post2.setAccount(account2);

          Post post3 = new Post();
          post3.setTitle("Title of post 3");
          post3.setBody("This is the body of post 3");
          post3.setAccount(account1);
          postService.save(post1);
          postService.save(post2);
          postService.save(post3);
      }
    }
}
