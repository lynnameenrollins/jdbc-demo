package com.training.jdbc;


public class Product {
		String prod_id;
		String prod_name;
		String prod_desc;
		double price;
		
		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			long temp;
			temp = Double.doubleToLongBits(price);
			result = prime * result + (int) (temp ^ (temp >>> 32));
			result = prime * result + ((prod_desc == null) ? 0 : prod_desc.hashCode());
			result = prime * result + ((prod_id == null) ? 0 : prod_id.hashCode());
			result = prime * result + ((prod_name == null) ? 0 : prod_name.hashCode());
			return result;
		}
		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			Product other = (Product) obj;
			if (Double.doubleToLongBits(price) != Double.doubleToLongBits(other.price))
				return false;
			if (prod_desc == null) {
				if (other.prod_desc != null)
					return false;
			} else if (!prod_desc.equals(other.prod_desc))
				return false;
			if (prod_id == null) {
				if (other.prod_id != null)
					return false;
			} else if (!prod_id.equals(other.prod_id))
				return false;
			if (prod_name == null) {
				if (other.prod_name != null)
					return false;
			} else if (!prod_name.equals(other.prod_name))
				return false;
			return true;
		}
		public Product(String prod_id, String prod_name, String prod_desc, double price) {
			super();
			this.prod_id = prod_id;
			this.prod_name = prod_name;
			this.prod_desc = prod_desc;
			this.price = price;
		}
		public String getProd_id() {
			return prod_id;
		}
		public void setProd_id(String prod_id) {
			this.prod_id = prod_id;
		}
		public String getProd_name() {
			return prod_name;
		}
		public void setProd_name(String prod_name) {
			this.prod_name = prod_name;
		}
		public String getProd_desc() {
			return prod_desc;
		}
		public void setProd_desc(String prod_desc) {
			this.prod_desc = prod_desc;
		}
		public double getPrice() {
			return price;
		}
		public void setPrice(double price) {
			this.price = price;
		}
		
		
}
