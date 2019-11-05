package upjs.sk.Prezencka.gui;

import javafx.beans.property.DoubleProperty;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class AttendenceFxModel {

	private StringProperty name = new SimpleStringProperty();
	private IntegerProperty count = new SimpleIntegerProperty();
	private DoubleProperty percent = new SimpleDoubleProperty();

	public StringProperty nameProperty() {
		return name;
	}

	public String getName() {
		return name.get();
	}

	public void setName(String name) {
		this.name.set(name);
	}

	public IntegerProperty countProperty() {
		return count;
	}

	public Integer getCount() {
		return count.get();
	}

	public void setCount(Integer count) {
		this.count.set(count);
	}

	public DoubleProperty percentProperty() {
		return percent;
	}

	public Double getPercent() {
		return percent.get();
	}

	public void setPercent(Double percent) {
		this.percent.set(percent);
	}
}