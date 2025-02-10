
import {useEffect, useState} from "react";
import ProductCard from "./ProductCard";
import { ProductDTO } from "@/models/productDTO.ts";
import ProductForm from "./ProductForm";
import { Button } from "./ui/button";
import { PlusCircle } from "lucide-react";
import {addProduct, deleteProduct, getProducts, updateProduct} from "@/api/api.ts";

const ProductGrid = () => {
  const [products, setProducts] = useState<ProductDTO[]>([]);
  const [isFormOpen, setIsFormOpen] = useState(false);
  const [editingProduct, setEditingProduct] = useState<ProductDTO | null>(null);

  useEffect(()=>  {
    getProducts().then(p=>setProducts(p.data))}
  ,[])

  const handleAddProduct = (newProduct: Omit<ProductDTO, "id">) => {
    const product = {
      ...newProduct,
      id: Math.max(...products.map((p) => p.id), 0) + 1,
    };
    addProduct(newProduct as ProductDTO).then(
        p =>{
          setProducts([...products, product]);
        }
    );
    setIsFormOpen(false);
  };

  const handleUpdateProduct = (updatedProduct: ProductDTO) => {

    updateProduct(updatedProduct).then(p=>{
      setProducts(
        products.map((p) => (p.id === updatedProduct.id ? updatedProduct : p))
      );
      setEditingProduct(null);
    })
  };

  const handleDeleteProduct = (id: number) => {
    deleteProduct(id).then(p=>{
      setProducts(products.filter((p) => p.id !== id));
    })
  };

  return (
    <div>
      <div className="flex justify-between items-center mb-6">
        <h2 className="text-2xl font-semibold">Featured Products</h2>
        <Button onClick={() => setIsFormOpen(true)} className="flex gap-2">
          <PlusCircle className="h-5 w-5" />
          Add Product
        </Button>
      </div>

      <div className="grid grid-cols-1 md:grid-cols-2 lg:grid-cols-3 xl:grid-cols-4 gap-6">
        {products.map((product) => (
          <ProductCard
            key={product.id}
            product={product}
            onEdit={setEditingProduct}
            onDelete={handleDeleteProduct}
          />
        ))}
      </div>

      {(isFormOpen || editingProduct) && (
        <ProductForm
          product={editingProduct}
          onSubmit={editingProduct ? handleUpdateProduct : handleAddProduct}
          onCancel={() => {
            setIsFormOpen(false);
            setEditingProduct(null);
          }}
        />
      )}
    </div>
  );
};

export default ProductGrid;
