import PropTypes from "prop-types";
// material
import { Grid } from "@mui/material";
import ShopProductCard from "./ProductCard";

// ----------------------------------------------------------------------

ProductList.propTypes = {
  products: PropTypes.array.isRequired,
};

export default function ProductList({ products }) {
  console.log("inside prodcutList");
  var productArray = Object.values(products);
  console.log(products);
  console.log(productArray);
  return (
    <Grid container spacing={3}>
      {productArray.map((product) => (
        <Grid key={product.id} item xs={12} sm={6} md={3} className="itsme">
          <ShopProductCard product={product} />
        </Grid>
      ))}
    </Grid>
  );
}
