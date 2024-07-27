package com.jatasra.demo.modern.page;

public sealed interface SuccessfulPage extends Page permits ExternalPage, GitHubPage{
  String content();
}
