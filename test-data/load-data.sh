curl -v -X POST -H "Content-Type: text/csv" http://MxAdmin:1@localhost:8080/ws-doc/Orders/ProductLabels --data-binary "@labels-data.csv"
curl -v -X POST -H "Content-Type: text/csv" http://MxAdmin:1@localhost:8080/ws-doc/Orders/Products --data-binary "@products-data.csv"
curl -v -X POST -H "Content-Type: text/csv" http://MxAdmin:1@localhost:8080/ws-doc/Orders/Address --data-binary "@address-2-data.csv"
curl -v -X POST -H "Content-Type: text/csv" http://MxAdmin:1@localhost:8080/ws-doc/Orders/Address --data-binary "@address-data.csv"
curl -v -X POST -H "Content-Type: text/csv" http://MxAdmin:1@localhost:8080/ws-doc/Orders/Address --data-binary "@addresses-uk-data.csv"
curl -v -X POST -H "Content-Type: text/csv" http://MxAdmin:1@localhost:8080/ws-doc/Orders/Customers --data-binary "@customers-data.csv"
curl -v -X POST -H "Content-Type: text/csv" http://MxAdmin:1@localhost:8080/ws-doc/Orders/Orders --data-binary "@orders-data.csv"
curl -v -X POST -H "Content-Type: text/csv" http://MxAdmin:1@localhost:8080/ws-doc/Orders/OrderLines --data-binary "@orderlines-data.csv"

