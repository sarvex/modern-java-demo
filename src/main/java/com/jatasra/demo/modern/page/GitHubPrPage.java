package com.jatasra.demo.modern.page;

import java.net.URI;
import java.util.Objects;
import java.util.Set;

public record GitHubPrPage(URI url, String content, Set<URI> links, int prNumber) implements GitHubPage {
  public GitHubPrPage {
    // checks as before
    Objects.requireNonNull(url);
    Objects.requireNonNull(content);
    Objects.requireNonNull(links);

    links = Set.copyOf(links);
  }

  public GitHubPrPage(URI url, String content, int prNumber) {
    this(url, content, Set.of(), prNumber);
  }
}
