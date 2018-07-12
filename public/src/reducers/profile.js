function profile(state = {}, action){

  switch(action.type){
    case 'UPDATE_INVENTORY':

      let inventoryItems = state;
      var existingInventoryItem = inventoryItems.find(c =>  c.productId === action.productId);

      if(existingInventoryItem){
        existingInventoryItem.stock -=  action.qty;
      }

      return [ ...inventoryItems.filter(ci => ci.productId !== action.productId), existingInventoryItem   ]


    case 'DATA_LOADED':
        
        return action.data;

    default:
    return state;
  }

}
export default profile;
