document.addEventListener("DOMContentLoaded", () => {
  const input_mname = document.querySelector("input#m_name");
  const input_mcode = document.querySelector("input#r_mcode");
  const input_mtel = document.querySelector("input#m_tel");
  const result_list = document.querySelector("div.search.list");

  const result_listClickHandler = (e) => {
    const member_item = e.target;
    if (member_item.tagName !== "DIV") {
      return false;
    }
    input_mcode.value = member_item.dataset.mcode;
    input_mname.value = member_item.dataset.mname;
    input_mtel.value = member_item.dataset.mtel;
    result_list.style.display = "none";
  };

  result_list?.addEventListener("click", result_listClickHandler);

  const mnameSearch = async (e) => {
    const mname = e.target.value;

    if (mname.length < 1) {
      result_list.style.display = "none";
      return false;
    }
    result_list.style.display = "block";
    const url = `${rootPath}/member/name/search?m_name=${mname}`;

    const response = await fetch(url);
    const result = await response.json();

    result_list.innerHTML = "";

    result.forEach((member) => {
      console.table(member);

      const member_item = document.createElement("div");
      const text = `${member.m_name} , ${member.m_tel}`;

      member_item.innerHTML = text.replaceAll(
        `${mname}`,
        `<span class="search-item">${mname}</span>`
      );
      member_item.dataset.mcode = member.m_code;
      member_item.dataset.mname = member.m_name;
      member_item.dataset.mtel = member.m_tel;

      result_list.appendChild(member_item);
    });
  };
  input_mname?.addEventListener(
    "keyup",
    debounce((e) => {
      mnameSearch(e);
    })
  );
});
