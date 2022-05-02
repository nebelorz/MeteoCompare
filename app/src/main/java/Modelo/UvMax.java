package Modelo;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class UvMax implements Serializable {

        @SerializedName("value")
        @Expose
        private Integer value;

        public Integer getValue() {
            return value;
        }
        public void setValue(Integer value) {
            this.value = value;
        }

        @Override
        public String toString() {
            return "UvMax{" +
                    "value='" + value +
                    '}';
        }
}
