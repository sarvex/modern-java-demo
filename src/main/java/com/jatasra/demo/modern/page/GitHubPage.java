package com.jatasra.demo.modern.page;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.stream.Stream;

public sealed interface GitHubPage extends SuccessfulPage permits GitHubPrPage, GitHubIssuePage {

  Set<Page> links();

  default Stream<Page> subtree() {
    var subtree = new ArrayList<Page>(Set.of(this));
    var upcomingPages = new LinkedHashSet<>(this.links());

    while (!upcomingPages.isEmpty()) {
      var nextPage = upcomingPages.removeFirst();
      if (!subtree.contains(nextPage) && nextPage instanceof GitHubPage page) {
        new LinkedHashSet<>(page.links())
            .reversed()
            .forEach(upcomingPages::addFirst);
      }

      subtree.add(nextPage);
    }

    return subtree.stream();
  }
}
