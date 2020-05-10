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
public final class AddController {
    /**
     * The inventory model of this add controller.
     */
    private InventoryModel inventoryModel;

    /**
     * The add view of this add controller.
     */
    private AddView addView;

    /**
     * Constructs a newly allocated {@code AddController} object with the specified inventory model and add view.
     *
     * @param inventoryModel the inventory model of this add controller
     * @param addView the add view of this add controller
     * @throws IllegalArgumentException if the {@code inventoryModel} argument or {@code addView} argument is
     * {@code null}
     */
    public AddController(InventoryModel inventoryModel, AddView addView) throws IllegalArgumentException {
        if (inventoryModel == null) {
            throw new IllegalArgumentException("inventoryModel argument is null");
        } else if (addView == null) {
            throw new IllegalArgumentException("addView argument is null");
        } else {
            this.inventoryModel = inventoryModel;
            this.addView = addView;

            this.addView.getAddButton().addActionListener(e -> this.getAddButtonSemantics());

            this.addView.getClearButton().addActionListener(e -> this.getClearButtonSemantics());
        } //end if
    } //AddController

    /**
     * Gets the semantics of an add view's add button.
     */
    private void getAddButtonSemantics() {
        //TODO implement method
                Optional<Product> sku = inventoryModel.searchBySku(addView.getSkuTextField().getText());

                boolean skuExists = sku.isPresent();
                boolean wPIsDouble = false;
                boolean rPIsDouble = false;
                boolean qIsInt = false;
                try{
                    Double.parseDouble(addView.getWholesalePriceTextField().getText());
                    wPIsDouble = true;
                }catch(NumberFormatException exp){
                    wPIsDouble = false;
                }
                try{
                    Double.parseDouble(addView.getRetailPriceTextField().getText());
                    rPIsDouble = true;
                }catch(NumberFormatException exp){
                    rPIsDouble = false;
                }
                try{
                    Integer.parseInt(addView.getQuantityTextField().getText());
                    qIsInt = true;
                }catch(NumberFormatException exp){
                    qIsInt = false;
                }
              //  boolean wholeSalePriceValid = Double.parseDouble(addView.getWholesalePriceTextField().getText()
                if(skuExists){
                    JOptionPane.showMessageDialog(null, "This product could not be added to the inventory!\nA product with the specified SKU already exists!", "Product Inventory", JOptionPane.ERROR_MESSAGE);
                    addView.getSkuTextField().requestFocus();
                }
                else if(wPIsDouble == false){
                    JOptionPane.showMessageDialog(null, "The specified wholesale price is not a valid number!", "Product Inventory", JOptionPane.ERROR_MESSAGE);
                    addView.getWholesalePriceTextField().requestFocus();
                }
                else if(rPIsDouble == false){
                    JOptionPane.showMessageDialog(null, "The specified retail price is not a valid number!", "Product Inventory", JOptionPane.ERROR_MESSAGE);
                    addView.getRetailPriceTextField().requestFocus();
                }
                else if(qIsInt == false){
                    JOptionPane.showMessageDialog(null, "The specified quantity is not a valid number!", "Product Inventory", JOptionPane.ERROR_MESSAGE);
                    addView.getQuantityTextField().requestFocus();
                }
                else{
                    Product product = new Product(addView.getSkuTextField().getText(), addView.getNameTextField().getText(), Double.parseDouble(addView.getWholesalePriceTextField().getText()), Double.parseDouble(addView.getRetailPriceTextField().getText()), Integer.parseInt(addView.getQuantityTextField().getText()));
                    JOptionPane.showMessageDialog(null, "This product has been added to the inventory.", "Product Inventory", JOptionPane.INFORMATION_MESSAGE);
                    inventoryModel.add(product);
                }
            }


    /**
     * Gets the semantics of an add view's clear button.
     */
    private void getClearButtonSemantics() {
        //TODO implement method
        JButton clearButton = addView.getClearButton();
                addView.getSkuTextField().setText("");
                addView.getSkuTextField().requestFocus();
                addView.getNameTextField().setText("");
                addView.getNameTextField().requestFocus();
                addView.getWholesalePriceTextField().setText("");
                addView.getWholesalePriceTextField().requestFocus();
                addView.getRetailPriceTextField().setText("");
                addView.getRetailPriceTextField().requestFocus();
                addView.getQuantityTextField().setText("");
                addView.getQuantityTextField().requestFocus();

    } //getClearButtonSemantics

    /**
     * Gets the hash code of this add controller.
     *
     * @return the hash code of this add controller
     */
    @Override
    public int hashCode() {
        int result = 23;

        result = 19 * result + (this.inventoryModel == null ? 0 : this.inventoryModel.hashCode());

        result = 19 * result + (this.addView == null ? 0 : this.addView.hashCode());

        return result;
    } //hashCode

    /**
     * Determines whether or not this add controller is equal to the specified object. {@code true} is returned if and
     * only if the specified object is an instance of {@code AddController}, and its field values are equal to this
     * add controller's.
     *
     * @param anObject the object to be compared
     * @return {@code true}, if this add controller is equal to the specified object, and {@code false} otherwise
     */
    @Override
    public boolean equals(Object anObject) {
        return (anObject instanceof AddController)
                && (this.inventoryModel == null ? ((AddController) anObject).inventoryModel ==  null : this.inventoryModel.equals(((AddController) anObject).inventoryModel))
                && (this.addView == null ? ((AddController) anObject).addView ==  null : this.addView.equals(((AddController) anObject).addView));
    } //equals

    /**
     * Gets a {@code String} representation of this add controller.
     *
     * @return a {@code String} representation of this add controller
     */
    @Override
    public String toString() {
        return String.format("AddController[%s, %s]", this.inventoryModel, this.addView);
    } //toString
}