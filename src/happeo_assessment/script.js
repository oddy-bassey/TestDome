  // QUESTION 1

  function numberOfItems(arr, item) {
    // Write the code that goes here
    let count = 0;

    for(let data of arr){
        if(Array.isArray(data)){
            count += numberOfItems(data, item);
        }else {
            if(data === item) count +=1;
        }
    }
    return count;
  }

  var arr = [
    25,
    "apple",
    ["banana", "strawberry", "apple", 25]
  ];
  console.log(numberOfItems(arr, 25));
  console.log(numberOfItems(arr, "apple"));


  // QUESTION 2

  function transformDateFormat(dates) {
    // Write the code that goes here

    return dates.map(date => {
        if (!isNaN(Date.parse(date))) {
            const data = new Date(date);

            return `${data.getFullYear()}${data.getMonth()}${data.getDay()}`;
        }
    });
  }

  var dates = transformDateFormat(["2010/02/20", "19/12/2016", "11-18-2012", "20130720"]);
  for (let index = 0; index < dates.length; ++index) {
    console.log(dates[index]);
  }