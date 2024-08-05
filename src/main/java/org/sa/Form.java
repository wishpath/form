package org.sa;

import java.util.stream.Stream;

public class Form {
  private StringBuilder format = new StringBuilder();

  public Form(String... formAdditives) {
    Stream.of(formAdditives)
        .forEach(part -> format.append(part.startsWith("%") ? "%s" : part));
  }

  public String with(Object... insertables) {
    return String.format(format.toString(), insertables);
  }

  public String of(Object... insertables) {
    return with(insertables);
  }
}