
import { Button } from "@/components/ui/button";
import { Card, CardContent, CardFooter } from "@/components/ui/card";
import { ProductDTO } from "@/models/productDTO.ts";

interface ProductCardProps {
  product: ProductDTO;
  onEdit?: (product: ProductDTO) => void;
  onDelete?: (id: number) => void;
}

const ProductCard = ({ product, onEdit, onDelete }: ProductCardProps) => {
  return (
    <Card className="overflow-hidden transition-all duration-300 hover:animate-card-hover">
      <CardContent className="p-0">
        <img
          src={product.image}
          alt={product.name}
          className="w-full h-48 object-cover"
        />
        <div className="p-4">
          <h3 className="text-lg font-semibold">{product.name}</h3>
          <p className="text-gray-600 mb-2">${product.price.toFixed(2)}</p>
          <p className="text-sm text-gray-500 line-clamp-2">{product.description}</p>
        </div>
      </CardContent>
      <CardFooter className="p-4 pt-0 flex gap-2">
        <Button className="flex-1" onClick={() => console.log("Add to cart:", product.id)}>
          Add to Cart
        </Button>
        {onEdit && (
          <Button variant="outline" onClick={() => onEdit(product)}>
            Edit
          </Button>
        )}
        {onDelete && (
          <Button variant="destructive" onClick={() => onDelete(product.id)}>
            Delete
          </Button>
        )}
      </CardFooter>
    </Card>
  );
};

export default ProductCard;
