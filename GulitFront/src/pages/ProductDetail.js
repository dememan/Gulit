import React, { useContext, useState, useEffect } from "react";
import axios from "axios";
import { APIConfig } from "src/store/Api-Config";
import { mockImgProduct } from "../utils/mockImages";

import { Container, Grid } from '@mui/material'; 
import { useParams} from 'react-router-dom';
import Page from 'src/components/Page';
import ProductDetailCard from 'src/components/_dashboard/products/ProductDetailCard';
import Typography from 'src/theme/overrides/Typography';

const ProductDetail = (props) => { 
    
    console.log('inside product detail' ) ;
    let { id } = useParams();
   console.log(id);

   
  const APIs = useContext(APIConfig);
  const productAPI = APIs.ProductAPI;

  const [product, setProductList] = useState([ ]);
  function fetchProductHandler() {
    const headers = {
      "Access-Control-Allow-Origin": "*",
    };

    console.log("inside product detail get request");
    console.log(productAPI);
    axios(productAPI+id, { headers })
      .then((res) => {
        const response = res.data;

        console.log(response);
        setProductList(response);
        return product;
      })
      .catch((error) => {
        console.log(error.message);
      });
  }
  useEffect(fetchProductHandler, []); // This will be fetched when mounted



    return (
        <Page title="Dashboard: Product Detail | Minimal-UI">
        <Container>
         
        <Grid key={product.id} item xs={12} sm={12} md={12}  >
        <ProductDetailCard product={product} />
      </Grid>
      </Container>
      </Page>
    );
}

export default ProductDetail;