// document.addEventListener("DOMContentLoaded", () => {
//     const dishesContainer = document.getElementById("dishesContainer");
//     const searchInput = document.getElementById("searchInput");
//     const cuisineSelect = document.getElementById("cusine");
//     const vegNonVegSelect = document.getElementById("vegNonVeg");

//     const dishes = [
//         { 
//             name: "Margherita Pizza", 
//             cuisine: "Italian", 
//             type: "Veg" 
//         },
//         { 
//             name: "Butter Chicken",
//             cuisine: "Indian", 
//             type: "Non-Veg" 
//         },
//     ];

//     function renderDishes() {
//         const cuisineFilter = cuisineSelect.value;
//         const vegNonVegFilter = vegNonVegSelect.value;
//         const searchTerm = searchInput.value.toLowerCase();

//         dishesContainer.innerHTML = "";

//         dishes.forEach(dish => {
//             const cuisineMatch = cuisineFilter === "all" || dish.cuisine.toLowerCase() === cuisineFilter;
//             const vegNonVegMatch = vegNonVegFilter === "all" || dish.type.toLowerCase() === vegNonVegFilter;
//             const searchMatch = dish.name.toLowerCase().includes(searchTerm);

//             if (cuisineMatch && vegNonVegMatch && searchMatch) {
//                 const dishCard = document.createElement("div");
//                 dishCard.className = "card mb-3";

//                 const cardBody = document.createElement("div");
//                 cardBody.className = "card-body";

//                 const dishTitle = document.createElement("h5");
//                 dishTitle.className = "card-title";
//                 dishTitle.textContent = dish.name;

//                 const cuisineInfo = document.createElement("p");
//                 cuisineInfo.className = "card-text";
//                 cuisineInfo.textContent = `Cuisine: ${dish.cuisine}`;

//                 const typeInfo = document.createElement("p");
//                 typeInfo.className = "card-text";
//                 typeInfo.textContent = `Type: ${dish.type}`;

//                 cardBody.appendChild(dishTitle);
//                 cardBody.appendChild(cuisineInfo);
//                 cardBody.appendChild(typeInfo);

//                 dishCard.appendChild(cardBody);
//                 dishesContainer.appendChild(dishCard);
//             }
//         });
//     }

//     // Event listeners
//     cuisineSelect.addEventListener("change", renderDishes);
//     vegNonVegSelect.addEventListener("change", renderDishes);
//     searchInput.addEventListener("input", renderDishes);

//     // Initial render
//     renderDishes();
// });

const search=()=>{
    const searchInput = document.getElementById("searchInput").value.toUpperCase();
    const dishitems = document.getElementById("dishes-list");
    const dishes= document.querySelectorAll(".dishes");
    const dname = document.getElementsByTagName("h2");

    for(var i=0;i<dname.length;i++)
    {
        let match=dishes[i].getElementsByTagName('h2')[0];

        if(match)
        {
            let textvalue=match.textContent || match.innerHTML;

            if(textvalue.toUpperCase().indexOf(searchInput)>-1)
            {
                dishes[i].style.display = "";
            }
            else{
                dishes[i].style.display ="none";
            }
        }
    }
}