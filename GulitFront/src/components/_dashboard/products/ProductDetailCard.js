import PropTypes from "prop-types";
import { Link as RouterLink } from "react-router-dom";
// material
import { Box, Card, Link,Grid, Typography, Stack, Container, Button } from "@mui/material";
import { styled } from "@mui/material/styles";
// utils
import { fCurrency } from "../../../utils/formatNumber";
//
import Label from "../../Label";
import { useState,useRef, useContext } from "react"; 

import InputLabel from '@mui/material/InputLabel';
import MenuItem from '@mui/material/MenuItem';
import FormControl from '@mui/material/FormControl';
import Select from '@mui/material/Select';

import { filter } from 'lodash';
import { Icon } from '@iconify/react';
import plusFill from '@iconify/icons-eva/plus-fill';
import CartIcon from "src/layouts/CartIcon";
import CartContext from "src/store/cart-context";

// ----------------------------------------------------------------------

const ProductImgStyle = styled("img")({
  top: 0,
  width: "100%",
  height: "100%",
  objectFit: "cover",
  position: "absolute",
});


// ----------------------------------------------------------------------

ProductDetailCard.propTypes = {
  product: PropTypes.object 
};

function ProductDetailCard({ product }) {


  console.log('inside product detail card');

  const {id,name,description,isActive,price}=product;
  //const { id, name, cover, price, status, priceSale ,description,brand,category} = product;
   console.log(product); 
const status=isActive;
const priceSale=price;  

  const [amountIsValid, setAmountIsValid] = useState(true);
  const amountInputRef = useRef();

  const cartCtx = useContext(CartContext);

  //const priceView = `$${price.toFixed(2)}`;

  const [qty, setQty] = useState(1);

  const handleChange = (event) => {
    setQty(event.target.value);
  };

  const cartHandler = (event) => {
    event.preventDefault();

    
    console.log(qty);
    const enteredAmountNumber = +qty;
    console.log(enteredAmountNumber);
    if (
      qty === 0 ||
      enteredAmountNumber < 1 ||
      enteredAmountNumber > 5
    ) {
      setAmountIsValid(false);
      return;
    }

    cartCtx.addItem({
      id: id,
      name: name,
      amount: enteredAmountNumber,
      price: price 
    });

    console.log('cart items');
    console.log(id, name,enteredAmountNumber, price );
    console.log(cartCtx.items);

  };



 
  return (
    <Container>
    <Grid container  spacing={4}>
      <Grid item xs={6}>
      <Card>
      <Box sx={{ pt: "100%", position: "relative" }}>
        {status && (
          <Label
            variant="filled"
            color={(status === "sale" && "error") || "info"}
            sx={{
              zIndex: 9,
              top: 16,
              right: 16,
              position: "absolute",
              textTransform: "uppercase",
            }}
          >
            {status}
          </Label>
        )}
        <ProductImgStyle
          alt={name}
          src={`/static/mock-images/products/product_${id}.jpg`}
        />
      </Box>

      <Stack spacing={2} sx={{ p: 3 }}>
         <Typography variant="subtitle4" noWrap>
            {description}
          </Typography>
      
      </Stack>
    </Card>
      </Grid>
      <Grid item xs={6}>
      <Link to={'/brand/' +name} color="inherit" underline="hover" component={RouterLink} >
        Brand :APPLE
      </Link>
      <Typography variant="subtitle1">
        {name}
      </Typography> 
   
      <Stack spacing={2} sx={{ p: 3 }}>
       
        <Stack
          direction="row"
          alignItems="center"
          justifyContent="space-between"
        >
          {/* <ColorPreview colors={colors} /> */}
          <Typography variant="subtitle1">
            <Typography
              component="span"
              variant="body1"
              sx={{
                color: "text.disabled",
                textDecoration: "line-through",
              }}
            >
             Price: {priceSale && fCurrency(priceSale)}
            </Typography>
            &nbsp;
            {fCurrency(price)}
          </Typography>
        </Stack>
      </Stack>
  
      <Stack spacing={2} sx={{ p: 3 }}>
       
       <Stack
         direction="row"
         alignItems="center"
         justifyContent="space-between"
       >
   <Box sx={{ minWidth: 120 }}>
    <FormControl fullWidth>
      <InputLabel id="demo-simple-select-label">Qty</InputLabel>
      <Select 
        labelId="demo-simple-select-label"
        id="item_qty" 
        label="Qty"   
          onChange={handleChange}
      >
        <MenuItem value={1} selected>One</MenuItem>
        <MenuItem value={2}>Two</MenuItem>
        <MenuItem value={3}>Three</MenuItem>
      </Select>

      {!amountIsValid && <p>Please enter a valid amount (1-5).</p>}
    </FormControl>
  </Box>
</Stack>
</Stack>
    
      <Box>
        <Stack direction="row" alignItems="left" justifyContent="space-between" mb={5}>          
          <Button
            variant="outlined"
            component={RouterLink}
           onClick={cartHandler}
           to="#" 
            startIcon={<Icon icon={plusFill} />}
          >
       Add to Cart </Button>
        </Stack> 
        <Stack direction="row" alignItems="right" justifyContent="space-between" mb={5}>         
          <Button
            variant="outlined"
            component={RouterLink}
            to="#" 
          >
          Buy Now
          </Button>
        </Stack>
        </Box>

        <Box>
        <Stack direction="row" alignItems="left" justifyContent="space-between" mb={5}>                  
<Typography variant="subtitle1">
       <a href="/products/reviews/1">Reviews</a> 
      </Typography>
      </Stack>
</Box>

      </Grid>
    </Grid>
 

  
  
  </Container>
  );
}


export default ProductDetailCard;