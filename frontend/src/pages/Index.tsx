import Navbar from "@/components/Navbar";
import ProductGrid from "@/components/ProductGrid";

const Index = () => {
  return (
    <div className="min-h-screen bg-gray-50">
      <Navbar />
      <main className="container mx-auto px-4 py-8">
        <section className="mb-12 text-center">
          <h1 className="text-4xl font-bold text-primary mb-4">Welcome to ShopEase</h1>
          <p className="text-xl text-gray-600">Discover amazing products at great prices</p>
        </section>
        <section>
          <h2 className="text-2xl font-semibold mb-6">Featured Products</h2>
          <ProductGrid />
        </section>
      </main>
    </div>
  );
};

export default Index;