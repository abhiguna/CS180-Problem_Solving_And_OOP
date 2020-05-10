import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Optional;

/**
 * A remove controller of a product inventory application.
 *
 * <p>CS18000 -- Summer 2019 -- Complex GUIs -- Homework</p>
 * @author Abhishek Gunasekar agunase
 * @version 10-12-2019 1.0
 **/
public final class UpdateController {
    /**
     * The inventory model of this update controller.
     */
    private InventoryModel inventoryModel;

    /**
     * The update view of this update controller.
     */
    private UpdateView updateView;

    /**
     * Constructs a newly allocated {@code UpdateController} object with the specified inventory model and update view.
     *
     * @param inventoryModel the inventory model of this update controller
     * @param updateView     the update view of this update controller
     * @throws IllegalArgumentException if the {@code inventoryModel} argument or {@code updateView} argument is
     *                                  {@code null}
     */
    public UpdateController(InventoryModel inventoryModel, UpdateView updateView) throws IllegalArgumentException {
        if (inventoryModel == null) {
            throw new IllegalArgumentException("inventoryModel argument is null");
        } else if (updateView == null) {
            throw new IllegalArgumentException("updateView argument is null");
        } else {
            this.inventoryModel = inventoryModel;
            this.updateView = updateView;

            this.updateView.getUpdateButton().addActionListener(e -> this.getUpdateButtonSemantics());

            this.updateView.getClearButton().addActionListener(e -> this.getClearButtonSemantics());
        } //end if
    } //UpdateController

    /**
     * Gets the semantics of an update view's update button.
     */
    private void getUpdateButtonSemantics() {
        //TODO implement method
        Optional<Product> sku = inventoryModel.searchBySku(updateView.getSkuTextField().getText());
        String nFieldValue = updateView.getNewFieldValueTextField().getText();
        boolean skuExists = sku.isPresent();
        Product product = null;
        boolean skuUnique = !skuExists;
        boolean wPIsDouble = false;
        boolean rPIsDouble = false;
        boolean qIsInt = false;
        if (!skuExists) {
            JOptionPane.showMessageDialog(null, "A product with the specified SKU does not exist in this inventory!", "Product Inventory", JOptionPane.ERROR_MESSAGE);
            updateView.getSkuTextField().requestFocus();
        } else if (updateView.getFieldComboBox().getSelectedItem() == null) {
            JOptionPane.showMessageDialog(null, "Please select a field!", "Product Inventory", JOptionPane.ERROR_MESSAGE);
            updateView.getFieldComboBox().requestFocus();
        } else {


            if (updateView.getFieldComboBox().getSelectedItem().equals("SKU")) {
                Optional<Product> sku2 = inventoryModel.searchBySku(nFieldValue);
                boolean ifNewExists = sku2.isPresent();
                if (ifNewExists) {
                    JOptionPane.showMessageDialog(null, "This products's SKU could not be updated!\nA product with the specified SKU already exists in the inventory.\nPlease enter a new SKU that is unique.", "Product Inventory", JOptionPane.ERROR_MESSAGE);
                    updateView.getSkuTextField().requestFocus();
                } else {
                    if (skuExists) {
                        product = sku.get();
                        JOptionPane.showMessageDialog(null, "This product's SKU has been updated.", "Product Inventory", JOptionPane.INFORMATION_MESSAGE);
                        product.setSku(nFieldValue);
                    }
                }
            } else if (updateView.getFieldComboBox().getSelectedItem().equals("Name")) {
                if (skuExists) {
                    product = sku.get();
                    JOptionPane.showMessageDialog(null, "This product's name has been updated.", "Product Inventory", JOptionPane.INFORMATION_MESSAGE);
                    product.setName(nFieldValue);
                }
            } else if (updateView.getFieldComboBox().getSelectedItem().equals("Wholesale price")) {
                try {
                    Double.parseDouble(updateView.getNewFieldValueTextField().getText());
                    wPIsDouble = true;
                } catch (NumberFormatException exp) {
                    wPIsDouble = false;
                }
                if (wPIsDouble == false) {
                    JOptionPane.showMessageDialog(null, "This product's wholesale price could not be updated!\nThe specified wholesale price is not a valid number!", "Product Inventory", JOptionPane.ERROR_MESSAGE);
                    updateView.getNewFieldValueTextField().requestFocus();
                } else {
                    if (skuExists) {
                        product = sku.get();
                        JOptionPane.showMessageDialog(null, "This product's wholesale price has been successfully updated.", "Product Inventory", JOptionPane.INFORMATION_MESSAGE);
                        product.setWholesalePrice(Double.parseDouble(nFieldValue));
                    }
                }
            } else if (updateView.getFieldComboBox().getSelectedItem().equals("Retail price")) {
                try {
                    Double.parseDouble(updateView.getNewFieldValueTextField().getText());
                    rPIsDouble = true;
                } catch (NumberFormatException exp) {
                    rPIsDouble = false;
                }
                if (rPIsDouble == false) {
                    JOptionPane.showMessageDialog(null, "This product's retail price could not be updated\nThe specified retail price is not a valid number!", "Product Inventory", JOptionPane.ERROR_MESSAGE);
                    updateView.getNewFieldValueTextField().requestFocus();
                } else {
                    if (skuExists) {
                        product = sku.get();
                        JOptionPane.showMessageDialog(null, "This product's retail price has been updated.", "Product Inventory", JOptionPane.INFORMATION_MESSAGE);
                        product.setRetailPrice(Double.parseDouble(nFieldValue));
                    }
                }
            } else if (updateView.getFieldComboBox().getSelectedItem().equals("Quantity")) {
                try {
                    Integer.parseInt(updateView.getNewFieldValueTextField().getText());
                    qIsInt = true;
                } catch (NumberFormatException exp) {
                    qIsInt = false;
                }
                if (qIsInt == false) {
                    JOptionPane.showMessageDialog(null, "This product's quantity could not be updated\nThe specified quantity is not a valid number!", "Product Inventory", JOptionPane.ERROR_MESSAGE);
                    updateView.getNewFieldValueTextField().requestFocus();
                } else {
                    if (skuExists) {
                        product = sku.get();
                        JOptionPane.showMessageDialog(null, "This product's quantity has been updated.", "Product Inventory", JOptionPane.INFORMATION_MESSAGE);
                        product.setQuantity(Integer.parseInt(nFieldValue));

                    }
                }
            }
        }
    } //getUpdateButtonSemantics

    /**
     * Gets the semantics of an update view's clear button.
     */
    private void getClearButtonSemantics() {
        //TODO implement method
        JButton clearButton = updateView.getClearButton();
        updateView.getSkuTextField().setText("");
        updateView.getSkuTextField().requestFocus();
        updateView.getFieldComboBox().setSelectedItem(null);
        updateView.getFieldComboBox().requestFocus();
        updateView.getNewFieldValueTextField().setText("");
        updateView.getNewFieldValueTextField().requestFocus();

    } //getClearButtonSemantics

    /**
     * Gets the hash code of this update controller.
     *
     * @return the hash code of this update controller
     */
    @Override
    public int hashCode() {
        int result = 23;

        result = 19 * result + (this.inventoryModel == null ? 0 : this.inventoryModel.hashCode());

        result = 19 * result + (this.updateView == null ? 0 : this.updateView.hashCode());

        return result;
    } //hashCode

    /**
     * Determines whether or not this update controller is equal to the specified object. {@code true} is returned if
     * and only if the specified object is an instance of {@code UpdateController}, and its field values are equal to
     * this update controller's.
     *
     * @param anObject the object to be compared
     * @return {@code true}, if this update controller is equal to the specified object, and {@code false} otherwise
     */
    @Override
    public boolean equals(Object anObject) {
        return (anObject instanceof UpdateController)
                && (this.inventoryModel == null ? ((UpdateController) anObject).inventoryModel == null : this.inventoryModel.equals(((UpdateController) anObject).inventoryModel))
                && (this.updateView == null ? ((UpdateController) anObject).updateView == null : this.updateView.equals(((UpdateController) anObject).updateView));
    } //equals

    /**
     * Gets a {@code String} representation of this update controller.
     *
     * @return a {@code String} representation of this update controller
     */
    @Override
    public String toString() {
        return String.format("UpdateController[%s, %s]", this.inventoryModel, this.updateView);
    } //toString
}