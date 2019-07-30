package net.opentechnology.triki.mtd.validators;

import org.apache.commons.lang.StringUtils;
import org.apache.wicket.validation.INullAcceptingValidator;
import org.apache.wicket.validation.IValidatable;
import org.apache.wicket.validation.ValidationError;

public class FormFieldNumericValidator implements INullAcceptingValidator<String> {

  private final String fieldName;

  public FormFieldNumericValidator(String fieldName) {
    this.fieldName = fieldName;
  }

  @Override
  public void validate(IValidatable<String> validatable) {
    String fieldValue = validatable.getValue();

    if (!StringUtils.isNumeric(fieldValue)) {
      ValidationError error = new ValidationError(this);
      error.addKey(this.getClass().getSimpleName() + ".numeric");
      error.setVariable("fieldName", fieldName);
      validatable.error(error);
    }
  }
}