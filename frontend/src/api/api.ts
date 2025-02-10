import {ProductDTO} from "@/models/productDTO.ts";
import axios, {AxiosResponse} from "axios";

export const addProduct = (product: ProductDTO): Promise<ProductDTO> => {
    return axios.post("http://localhost:8080/api/products",product);
}

export const getProducts =  (): Promise<AxiosResponse<ProductDTO[]>> => {
    return  axios.get("http://localhost:8080/api/products");
}

export const deleteProduct = (id: number) => {
    return  axios.delete("http://localhost:8080/api/products/"+id);
}

export const updateProduct = (product: ProductDTO) => {
    return  axios.put("http://localhost:8080/api/products/"+product.id,product);
}