import javax.swing.*;
import java.util.List;
import java.util.Optional;


/**
 * A remove controller of a product inventory application.
 *
 * <p>CS18000 -- Summer 2019 -- Complex GUIs -- Homework</p>
 * @author Abhishek Gunasekar agunase
 * @version 10-12-2019 1.0
 **/
public final class SearchController {
    /**
     * The inventory model of this search controller.
     */
    private InventoryModel inventoryModel;

    /**
     * The search view of this search controller.
     */
    private SearchView searchView;

    /**
     * Constructs a newly allocated {@code SearchController} object with the specified inventory model and search view.
     *
     * @param inventoryModel the inventory model of this search controller
     * @param searchView the search view of this search controller
     * @throws IllegalArgumentException if the {@code inventoryModel} argument or {@code searchView} argument is
     * {@code null}
     */
    public SearchController(InventoryModel inventoryModel, SearchView searchView) throws IllegalArgumentException {
        if (inventoryModel == null) {
            throw new IllegalArgumentException("inventoryModel argument is null");
        } else if (searchView == null) {
            throw new IllegalArgumentException("searchView argument is null");
        } else {
            this.inventoryModel = inventoryModel;
            this.searchView = searchView;

            this.searchView.getSearchButton().addActionListener(e -> this.getSearchButtonSemantics());

            this.searchView.getClearButton().addActionListener(e -> this.getClearButtonSemantics());
        } //end if
    } //SearchController

    /**
     * Gets the semantics of a search view's search button.
     */
    private void getSearchButtonSemantics() {
        //TODO implement method
        String fieldValue = searchView.getSearchValueTextField().getText();
        boolean wPIsDouble = false;
        boolean rPIsDouble = false;
        boolean qIsInt = false;
        Product product = null;
        if(searchView.getFieldComboBox().getSelectedItem() == null){
            JOptionPane.showMessageDialog(null, "Please select a field!", "Product Inventory", JOptionPane.ERROR_MESSAGE);
            searchView.getFieldComboBox().requestFocus();
        }else{
            if(searchView.getFieldComboBox().getSelectedItem().equals("SKU")){
                Optional<Product> sku = inventoryModel.searchBySku(fieldValue);
                boolean ifExists = sku.isPresent();
                if(!ifExists){
                    JOptionPane.showMessageDialog(null, "A product with the specified SKU does not exist in this inventory!", "Product Inventory", JOptionPane.ERROR_MESSAGE);
                    searchView.getSearchValueTextField().requestFocus();
                }else{
                    product = sku.get();
                    String result = ("SKU: " + product.getSku() + "\nName: " + product.getName() + "\nWholesale Price: " + product.getWholesalePrice() + "\nRetail Price: " + product.getRetailPrice() + "\nQuantity: " + product.getQuantity() + "\n\n");
                    searchView.getResultsTextArea().setText(result);
                }
            }else if(searchView.getFieldComboBox().getSelectedItem().equals("Name")){
                List<Product> name = inventoryModel.searchByName(fieldValue);
                String result = "";
                for(int i = 0; i < name.size(); i++){
                    result += ("SKU: " + name.get(i).getSku() + "\nName: " + name.get(i).getName() + "\nWholesale Price: " + name.get(i).getWholesalePrice() + "\nRetail Price: " + name.get(i).getRetailPrice() + "\nQuantity: " + name.get(i).getQuantity() + "\n\n");
                }
                searchView.getResultsTextArea().setText(result);
            }else if(searchView.getFieldComboBox().getSelectedItem().equals("Wholesale price")){
                try {
                    Double.parseDouble(searchView.getSearchValueTextField().getText());
                    wPIsDouble = true;
                } catch (NumberFormatException exp) {
                    wPIsDouble = false;
                }
                if (wPIsDouble == false) {
                    JOptionPane.showMessageDialog(null, "The specified search value is not a valid number!", "Product Inventory", JOptionPane.ERROR_MESSAGE);
                    searchView.getSearchValueTextField().requestFocus();
                }else{
                    List<Product> wP = inventoryModel.searchByWholesalePrice(Double.parseDouble(fieldValue));
                    String result = "";
                    for(int i = 0; i < wP.size(); i++){
                        result += ("SKU: " + wP.get(i).getSku() + "\nName: " + wP.get(i).getName() + "\nWholesale Price: " + wP.get(i).getWholesalePrice() + "\nRetail Price: " + wP.get(i).getRetailPrice() + "\nQuantity: " + wP.get(i).getQuantity() + "\n\n");
                    }
                    searchView.getResultsTextArea().setText(result);
                }
            }else if(searchView.getFieldComboBox().getSelectedItem().equals("Retail price")){
                try {
                    Double.parseDouble(searchView.getSearchValueTextField().getText());
                    rPIsDouble = true;
                } catch (NumberFormatException exp) {
                    rPIsDouble = false;
                }
                if (rPIsDouble == false) {
                    JOptionPane.showMessageDialog(null, "The specified search value is not a valid number!", "Product Inventory", JOptionPane.ERROR_MESSAGE);
                    searchView.getSearchValueTextField().requestFocus();
                }else{
                    List<Product> rP = inventoryModel.searchByRetailPrice(Double.parseDouble(fieldValue));
                    String result = "";
                    for(int i = 0; i < rP.size(); i++){
                        result += ("SKU: " + rP.get(i).getSku() + "\nName: " + rP.get(i).getName() + "\nWholesale Price: " + rP.get(i).getWholesalePrice() + "\nRetail Price: " + rP.get(i).getRetailPrice() + "\nQuantity: " + rP.get(i).getQuantity() + "\n\n");
                    }
                    searchView.getResultsTextArea().setText(result);
                }
            }else if(searchView.getFieldComboBox().getSelectedItem().equals("Quantity")){
                try {
                    Integer.parseInt(searchView.getSearchValueTextField().getText());
                    qIsInt = true;
                } catch (NumberFormatException exp) {
                    qIsInt = false;
                }
                if (qIsInt == false) {
                    JOptionPane.showMessageDialog(null, "The specified search value is not a valid number!", "Product Inventory", JOptionPane.ERROR_MESSAGE);
                    searchView.getSearchValueTextField().requestFocus();
                } else {
                    List<Product> q = inventoryModel.searchByQuantity(Integer.parseInt(fieldValue));
                    String result = "";
                    for(int i = 0; i < q.size(); i++){
                        result += "SKU: " + q.get(i).getSku() + "\nName: " + q.get(i).getName() + "\nWholesale Price: " + q.get(i).getWholesalePrice() + "\nRetail Price: " + q.get(i).getRetailPrice() + "\nQuantity: " + q.get(i).getQuantity() + "\n\n";
                    }
                    searchView.getResultsTextArea().setText(result);
                }
            }

        }
    } //getSearchButtonSemantics

    /**
     * Gets the semantics of a search view's clear button.
     */
    private void getClearButtonSemantics() {
        //TODO implement method
        JButton clearButton = searchView.getClearButton();
        searchView.getFieldComboBox().setSelectedItem(null);
        searchView.getFieldComboBox().requestFocus();
        searchView.getSearchValueTextField().setText("");
        searchView.getSearchValueTextField().requestFocus();
        searchView.getResultsTextArea().setText("");
        searchView.getResultsTextArea().requestFocus();
    } //getClearButtonSemantics

    /**
     * Gets the hash code of this search controller.
     *
     * @return the hash code of this search controller
     */
    @Override
    public int hashCode() {
        int result = 23;

        result = 19 * result + (this.inventoryModel == null ? 0 : this.inventoryModel.hashCode());

        result = 19 * result + (this.searchView == null ? 0 : this.searchView.hashCode());

        return result;
    } //hashCode

    /**
     * Determines whether or not this search controller is equal to the specified object. {@code true} is returned if
     * and only if the specified object is an instance of {@code SearchController}, and its field values are equal to
     * this search controller's.
     *
     * @param anObject the object to be compared
     * @return {@code true}, if this search controller is equal to the specified object, and {@code false} otherwise
     */
    @Override
    public boolean equals(Object anObject) {
        return (anObject instanceof SearchController)
                && (this.inventoryModel == null ? ((SearchController) anObject).inventoryModel ==  null : this.inventoryModel.equals(((SearchController) anObject).inventoryModel))
                && (this.searchView == null ? ((SearchController) anObject).searchView ==  null : this.searchView.equals(((SearchController) anObject).searchView));
    } //equals

    /**
     * Gets a {@code String} representation of this search controller.
     *
     * @return a {@code String} representation of this search controller
     */
    @Override
    public String toString() {
        return String.format("SearchController[%s, %s]", this.inventoryModel, this.searchView);
    } //toString
}