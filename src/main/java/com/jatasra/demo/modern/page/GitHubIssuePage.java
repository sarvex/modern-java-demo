package com.jatasra.demo.modern.page;

import java.net.URI;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public record GitHubIssuePage(URI url, String content, Set<Page> links, int issueNumber) implements GitHubPage {
  public GitHubIssuePage {
    Objects.requireNonNull(url);
    Objects.requireNonNull(content);
    links = Set.copyOf(links);
    if (issueNumber < 0) throw new IllegalArgumentException("issueNumber cannot be negative");
  }

  public GitHubIssuePage(URI url, String content, int issueNumber) {
    this(url, content, new HashSet<>(), issueNumber);
  }

  @Override
  public boolean equals(Object other) {
    return this == other
        || other instanceof GitHubIssuePage page
        && this.url.equals(page.url());
  }

  @Override
  public int hashCode() {
    return Objects.hashCode(url);
  }
}
