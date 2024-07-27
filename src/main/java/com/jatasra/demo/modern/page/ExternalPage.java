package com.jatasra.demo.modern.page;

import java.net.URI;
import java.util.Objects;

public record ExternalPage(URI url, String content ) implements SuccessfulPage {
  public ExternalPage {
    Objects.requireNonNull(url);
    Objects.requireNonNull(content);
    if (content.isBlank()) throw new IllegalArgumentException("Content cannot be blank");
  }

  @Override
  public boolean equals(Object object) {
    return this == object
        || object instanceof ExternalPage page
        && this.url.equals(page.url());
  }

  @Override
  public int hashCode() {
    return Objects.hashCode(url);
  }
}
