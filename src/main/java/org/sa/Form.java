package org.sa;

import java.util.stream.Stream;

/**
 * Superior to String.format(CONSTANT, additive1, additive2) for better readable usage:
 * CONSTANT.with(additive1, additive1);
 * <p>
 * Superior to String CONSTANT = "example %s abc" for having described each insertable:
 * Form CONSTANT = new Form("example %index abc");
 **/
public class Form {
  private static final String WORD_EDGE = "(?<=\\S)(?=\\s)|(?<=\\s)(?=\\S)";
  private StringBuilder format = new StringBuilder();

  /**
   * new Form("example", "%index", "abc") results in "example%sabc"
   **/
  public Form(String... formAdditives) {
    Stream.of(formAdditives)
          .forEach(additive -> format.append(additive.startsWith("%") ? "%s" : additive));
  }

  /**
   * new Form("example %index abc") results in "example %s abc"
   **/
  public Form(String form) {
    this(form.split(WORD_EDGE));
  }

  public String with(Object... insertables) {
    return String.format(format.toString(), insertables);
  }
  public String of(Object... insertables) {
    return with(insertables);
  }
}
