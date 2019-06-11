package com.beerhouse.model;

import java.math.BigDecimal;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.Valid;

import org.springframework.validation.annotation.Validated;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * Beer
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2019-06-05T22:58:55.295Z")


@Entity
@Table(name = "BEER")
@ApiModel
public class Beer   {

	@Id
	@GeneratedValue
	@Column(name = "id", nullable = false)
	@JsonProperty("id")
	private Long id = null;

	@Column(name = "name", length = 64, nullable = false)
	@JsonProperty("name")
	private String name = null;

	@Column(name = "ingredients", length = 200, nullable = false)
	@JsonProperty("ingredients")
	private String ingredients = null;

	@Column(name = "alcoholContent", length = 10, nullable = false)
	@JsonProperty("alcoholContent")
	private String alcoholContent = null;

	@Column(name = "price", precision=11, nullable = false)
	@JsonProperty("price")
	private BigDecimal price = null;

	@Column(name = "category", length = 20, nullable = false)
	@JsonProperty("category")
	private String category = null;

	public Beer id(Long id) {
		this.id = id;
		return this;
	}

	/**
	 * Get id
	 * @return id
	 **/
	@ApiModelProperty(value = "")


	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Beer name(String name) {
		this.name = name;
		return this;
	}

	/**
	 * Get name
	 * @return name
	 **/
	@ApiModelProperty(value = "")


	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Beer ingredients(String ingredients) {
		this.ingredients = ingredients;
		return this;
	}

	/**
	 * Get ingredients
	 * @return ingredients
	 **/
	@ApiModelProperty(value = "")
	public String getIngredients() {
		return ingredients;
	}

	public void setIngredients(String ingredients) {
		this.ingredients = ingredients;
	}

	public Beer alcoholContent(String alcoholContent) {
		this.alcoholContent = alcoholContent;
		return this;
	}

	/**
	 * Get alcoholContent
	 * @return alcoholContent
	 **/
	@ApiModelProperty(value = "")


	public String getAlcoholContent() {
		return alcoholContent;
	}

	public void setAlcoholContent(String alcoholContent) {
		this.alcoholContent = alcoholContent;
	}

	public Beer price(BigDecimal price) {
		this.price = price;
		return this;
	}

	/**
	 * Get price
	 * @return price
	 **/
	@ApiModelProperty(value = "")

	@Valid

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	public Beer category(String category) {
		this.category = category;
		return this;
	}

	/**
	 * Get category
	 * @return category
	 **/
	@ApiModelProperty(value = "")
	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}


	@Override
	public boolean equals(java.lang.Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		Beer beer = (Beer) o;
		return Objects.equals(this.id, beer.id) &&
				Objects.equals(this.name, beer.name) &&
				Objects.equals(this.ingredients, beer.ingredients) &&
				Objects.equals(this.alcoholContent, beer.alcoholContent) &&
				Objects.equals(this.price, beer.price) &&
				Objects.equals(this.category, beer.category);
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, name, ingredients, alcoholContent, price, category);
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("class Beer {\n");

		sb.append("    id: ").append(toIndentedString(id)).append("\n");
		sb.append("    name: ").append(toIndentedString(name)).append("\n");
		sb.append("    ingredients: ").append(toIndentedString(ingredients)).append("\n");
		sb.append("    alcoholContent: ").append(toIndentedString(alcoholContent)).append("\n");
		sb.append("    price: ").append(toIndentedString(price)).append("\n");
		sb.append("    category: ").append(toIndentedString(category)).append("\n");
		sb.append("}");
		return sb.toString();
	}

	/**
	 * Convert the given object to string with each line indented by 4 spaces
	 * (except the first line).
	 */
	private String toIndentedString(java.lang.Object o) {
		if (o == null) {
			return "null";
		}
		return o.toString().replace("\n", "\n    ");
	}
}

