package com.automationexercise.data;

public class Products {
    public enum Product {
        STYLISH_DRESS("Stylish Dress", "3"),
        BEAUTIFUL_PEACOCK_BLUE_COTTON_LINEN_SAREE("Beautiful Peacock Blue Cotton Linen Saree", "2"),
        MEN_TSHIRT("Men Tshirt", "1");

        private String name;
        private String quantity;

        Product(String name, String quantity) {
            this.name = name;
            this.quantity = quantity;
        }

        public String nome() {
            return name;
        }

        public String quantidade() {
            return quantity;
        }

    }}