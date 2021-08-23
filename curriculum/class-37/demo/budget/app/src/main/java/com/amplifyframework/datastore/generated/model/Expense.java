package com.amplifyframework.datastore.generated.model;

import com.amplifyframework.core.model.annotations.BelongsTo;
import com.amplifyframework.core.model.temporal.Temporal;

import java.util.List;
import java.util.UUID;
import java.util.Objects;

import androidx.core.util.ObjectsCompat;

import com.amplifyframework.core.model.Model;
import com.amplifyframework.core.model.annotations.Index;
import com.amplifyframework.core.model.annotations.ModelConfig;
import com.amplifyframework.core.model.annotations.ModelField;
import com.amplifyframework.core.model.query.predicate.QueryField;

import static com.amplifyframework.core.model.query.predicate.QueryField.field;

/** This is an auto generated class representing the Expense type in your schema. */
@SuppressWarnings("all")
@ModelConfig(pluralName = "Expenses")
@Index(name = "expenseItem", fields = {"accountId"})
public final class Expense implements Model {
  public static final QueryField ID = field("Expense", "id");
  public static final QueryField NAME = field("Expense", "name");
  public static final QueryField DESCRIPTION = field("Expense", "description");
  public static final QueryField COST = field("Expense", "cost");
  public static final QueryField ACCOUNT = field("Expense", "accountId");
  private final @ModelField(targetType="ID", isRequired = true) String id;
  private final @ModelField(targetType="String", isRequired = true) String name;
  private final @ModelField(targetType="String") String description;
  private final @ModelField(targetType="Float") Double cost;
  private final @ModelField(targetType="Account", isRequired = true) @BelongsTo(targetName = "accountId", type = Account.class) Account account;
  private @ModelField(targetType="AWSDateTime", isReadOnly = true) Temporal.DateTime createdAt;
  private @ModelField(targetType="AWSDateTime", isReadOnly = true) Temporal.DateTime updatedAt;
  public String getId() {
      return id;
  }
  
  public String getName() {
      return name;
  }
  
  public String getDescription() {
      return description;
  }
  
  public Double getCost() {
      return cost;
  }
  
  public Account getAccount() {
      return account;
  }
  
  public Temporal.DateTime getCreatedAt() {
      return createdAt;
  }
  
  public Temporal.DateTime getUpdatedAt() {
      return updatedAt;
  }
  
  private Expense(String id, String name, String description, Double cost, Account account) {
    this.id = id;
    this.name = name;
    this.description = description;
    this.cost = cost;
    this.account = account;
  }
  
  @Override
   public boolean equals(Object obj) {
      if (this == obj) {
        return true;
      } else if(obj == null || getClass() != obj.getClass()) {
        return false;
      } else {
      Expense expense = (Expense) obj;
      return ObjectsCompat.equals(getId(), expense.getId()) &&
              ObjectsCompat.equals(getName(), expense.getName()) &&
              ObjectsCompat.equals(getDescription(), expense.getDescription()) &&
              ObjectsCompat.equals(getCost(), expense.getCost()) &&
              ObjectsCompat.equals(getAccount(), expense.getAccount()) &&
              ObjectsCompat.equals(getCreatedAt(), expense.getCreatedAt()) &&
              ObjectsCompat.equals(getUpdatedAt(), expense.getUpdatedAt());
      }
  }
  
  @Override
   public int hashCode() {
    return new StringBuilder()
      .append(getId())
      .append(getName())
      .append(getDescription())
      .append(getCost())
      .append(getAccount())
      .append(getCreatedAt())
      .append(getUpdatedAt())
      .toString()
      .hashCode();
  }
  
  @Override
   public String toString() {
    return new StringBuilder()
      .append("Expense {")
      .append("id=" + String.valueOf(getId()) + ", ")
      .append("name=" + String.valueOf(getName()) + ", ")
      .append("description=" + String.valueOf(getDescription()) + ", ")
      .append("cost=" + String.valueOf(getCost()) + ", ")
      .append("account=" + String.valueOf(getAccount()) + ", ")
      .append("createdAt=" + String.valueOf(getCreatedAt()) + ", ")
      .append("updatedAt=" + String.valueOf(getUpdatedAt()))
      .append("}")
      .toString();
  }
  
  public static NameStep builder() {
      return new Builder();
  }
  
  /** 
   * WARNING: This method should not be used to build an instance of this object for a CREATE mutation.
   * This is a convenience method to return an instance of the object with only its ID populated
   * to be used in the context of a parameter in a delete mutation or referencing a foreign key
   * in a relationship.
   * @param id the id of the existing item this instance will represent
   * @return an instance of this model with only ID populated
   * @throws IllegalArgumentException Checks that ID is in the proper format
   */
  public static Expense justId(String id) {
    try {
      UUID.fromString(id); // Check that ID is in the UUID format - if not an exception is thrown
    } catch (Exception exception) {
      throw new IllegalArgumentException(
              "Model IDs must be unique in the format of UUID. This method is for creating instances " +
              "of an existing object with only its ID field for sending as a mutation parameter. When " +
              "creating a new object, use the standard builder method and leave the ID field blank."
      );
    }
    return new Expense(
      id,
      null,
      null,
      null,
      null
    );
  }
  
  public CopyOfBuilder copyOfBuilder() {
    return new CopyOfBuilder(id,
      name,
      description,
      cost,
      account);
  }
  public interface NameStep {
    AccountStep name(String name);
  }
  

  public interface AccountStep {
    BuildStep account(Account account);
  }
  

  public interface BuildStep {
    Expense build();
    BuildStep id(String id) throws IllegalArgumentException;
    BuildStep description(String description);
    BuildStep cost(Double cost);
  }
  

  public static class Builder implements NameStep, AccountStep, BuildStep {
    private String id;
    private String name;
    private Account account;
    private String description;
    private Double cost;
    @Override
     public Expense build() {
        String id = this.id != null ? this.id : UUID.randomUUID().toString();
        
        return new Expense(
          id,
          name,
          description,
          cost,
          account);
    }
    
    @Override
     public AccountStep name(String name) {
        Objects.requireNonNull(name);
        this.name = name;
        return this;
    }
    
    @Override
     public BuildStep account(Account account) {
        Objects.requireNonNull(account);
        this.account = account;
        return this;
    }
    
    @Override
     public BuildStep description(String description) {
        this.description = description;
        return this;
    }
    
    @Override
     public BuildStep cost(Double cost) {
        this.cost = cost;
        return this;
    }
    
    /** 
     * WARNING: Do not set ID when creating a new object. Leave this blank and one will be auto generated for you.
     * This should only be set when referring to an already existing object.
     * @param id id
     * @return Current Builder instance, for fluent method chaining
     * @throws IllegalArgumentException Checks that ID is in the proper format
     */
    public BuildStep id(String id) throws IllegalArgumentException {
        this.id = id;
        
        try {
            UUID.fromString(id); // Check that ID is in the UUID format - if not an exception is thrown
        } catch (Exception exception) {
          throw new IllegalArgumentException("Model IDs must be unique in the format of UUID.",
                    exception);
        }
        
        return this;
    }
  }
  

  public final class CopyOfBuilder extends Builder {
    private CopyOfBuilder(String id, String name, String description, Double cost, Account account) {
      super.id(id);
      super.name(name)
        .account(account)
        .description(description)
        .cost(cost);
    }
    
    @Override
     public CopyOfBuilder name(String name) {
      return (CopyOfBuilder) super.name(name);
    }
    
    @Override
     public CopyOfBuilder account(Account account) {
      return (CopyOfBuilder) super.account(account);
    }
    
    @Override
     public CopyOfBuilder description(String description) {
      return (CopyOfBuilder) super.description(description);
    }
    
    @Override
     public CopyOfBuilder cost(Double cost) {
      return (CopyOfBuilder) super.cost(cost);
    }
  }
  
}