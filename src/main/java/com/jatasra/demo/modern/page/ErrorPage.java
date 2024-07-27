package com.jatasra.demo.modern.page;

import java.net.URL;
import java.util.Objects;

public record ErrorPage(URL url, Exception ex) implements Page {
  public ErrorPage {
    Objects.requireNonNull(url);
    Objects.requireNonNull(ex);
  }

  @Override
  public boolean equals(Object other) {
    return other == this
        || other instanceof ErrorPage page
        && this.url.equals(page.url());
  }

  @Override
  public int hashCode() {
    return Objects.hashCode(url);
  }
}
